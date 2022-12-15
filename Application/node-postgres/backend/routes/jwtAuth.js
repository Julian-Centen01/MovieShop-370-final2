const router = require("express").Router()
const {query} = require("../models/posgres-queries");
const bcrypt = require('bcrypt')
const jwtGenerator = require("../utils/jwtGenerator")

// registering
router.post("/register", async (req,res) => {
    try {
            // 1. destructure the req.body (name, email, password)
            const {username, email, password} = req.body

            // 2. check user exists (if user exists throw error)
            const user = await query("SELECT * FROM users WHERE email = $1", [
                email
            ])
            // if theres a row returned throw unAUth (401) and error msg 
            if(user.rows.length !== 0){
                return res.status(401).send("Users Already Exists!")
            }
            // 3. crypt the user password
            const saltRound = 10
            const salt = await bcrypt.genSalt
            (saltRound)

            const bcryptPassword = await bcrypt.hash
            (password,salt)
            // 4. enter the new user inside our database
            const newUser = await query(`INSERT INTO users (username, password, email)
            VALUES ($1, $2, $3) RETURNING *`,
             [username, bcryptPassword , email])

            // 5. generating our jwt token
        
            const token =  jwtGenerator(newUser.rows[0].userID)
            res.json({token})
        

    } catch (err) {
        console.error(err.message)
        res.status(500).send("Server Error")
    }
})
module.exports = router;