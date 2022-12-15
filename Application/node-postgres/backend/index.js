const {HOST, PORT} = require('./config');
const http = require('./http');
const {server} = require('./socket');
const usersRouter = require("./routes/users");
const moviesRouter = require("./routes/movies");
const authenticationRouter = require("./routes/authentication");
const jwtAuthRouter = require("./routes/jwtAuth");
const cors = require("cors");

http.use(cors())

http.use('/users', usersRouter);
http.use('/movies', moviesRouter);
http.use('/', authenticationRouter);

// register and login routes
http.use('/auth', jwtAuthRouter)

server.listen(PORT, HOST, () => {
    console.log(`App running on port ${PORT}.`)
});
