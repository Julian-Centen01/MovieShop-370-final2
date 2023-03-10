const {query} = require("./posgres-queries");
const bcrypt = require('bcrypt')
const getMovie = () => {
    return query("SELECT * FROM movies")
        .then(({rows}) => rows);
}

const getUser = () => {
    return query('SELECT * FROM users')
        .then(({rows}) => rows);
}

const postUser = ({username, password, email})  => {
    return query(`INSERT INTO users (username, password, email)
                  VALUES ($1, $2, $3) RETURNING *`,
        [username, password, email])
        .then(({rows}) => rows);
}

const searchMovie = (body) => {
    const {title} = body
    console.log(title)
    return query('SELECT title FROM movies WHERE title LIKE $1', [`%${title}%`])
        .then(({rows}) => rows);
};

const userExists = ({username, password}) => {
    return query(`SELECT * FROM users  
    WHERE username = $1 AND password = $2`,
[username, password])
.then(({rows}) => rows);
}

const friendList = ({id}) => {
    query('SELECT u.* FROM users u INNER JOIN friends f on u.id = f.friend_id WHERE f.user_id=$1', [id])
        .then(({rows}) => rows);
}

const setUser = ({username, password, email})  => {
    return  query("SELECT * FROM users WHERE email = $1", [
         email]).then(({rows}) => rows);                 
        }


module.exports = {
    searchMovie,
    getMovie,
    postUser,
    getUser,
    friendList,
    userExists,
    setUser,
}