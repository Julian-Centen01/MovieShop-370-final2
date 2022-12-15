const {Router} = require('express');
const movie_model = require("../models/movie_model");

const router = Router();

router.post("/signUp", (req, res) => {
    movie_model.postUser(req.body)
        .then(response => {
            res.status(200).send(response);
        })
        .catch(error => {
            res.status(500).send(error);
        });
});

router.post("/login", (req,res) => {
    movie_model.userExists(req.body.username,req.body.password),
    (err,result) => {
    if(err) {
        res.send({err:err})
    }
    if(result.length > 0){
        res.send(result)
    } else{
        res.send({ message: "Invalid username/password!"})
    }
}
})

router.get("/profile", (req,res) => {
    res.json("profile")
})

module.exports = router;