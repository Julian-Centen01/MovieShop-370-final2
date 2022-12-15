import React from 'react';
// import '../css/styles.css';
// import '../css/bootstrap.css';
import {Link} from 'react-router-dom';
import {Button, ButtonGroup, Col, Form, FormGroup, Image, Row, Stack} from "react-bootstrap";
import Navbar from '../components/navbar/navbar.js';
// will any of these work?
// <link rel="preconnect" href="https://fonts.googleapis.com"></link>;
// <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin></link>;
// <link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat&family=Sacramento&display=swap" rel="stylesheet"></link>;
import Logo from '../images/Logo.png';
import movies from '../images/movies.png';
import friends from '../images/friends.png';
import BG from "../images/flecks.png";

class Navigation extends React.Component {
    render() {
        return (
            <main>
                <Navbar/>
                <div className="container-fluid" style={{ backgroundImage: `url(${BG})` }}>

                    <div className="row">
                        <br/>

                    </div>
                    <div className="row">

                        {/*FIRST COLUMN */}
                        <div className="col-sm text-center">
                        </div>
                        {/*MIDDLE COLUMN */}
                        <div className="col-lg-6">

                            <h1 className=" text-light text-center">Welcome to Groovy Movies!</h1>
                            <p className="lead text-center text-light">The source for all the best movies</p>
                            <br/>
                            <img src={movies} alt=""/>
                            <p className="lead text-center text-light">Here you can shop for all your favorite movies!</p>
                            <br/>
                            <img src={friends} alt=""/>
                            <p className="lead text-center text-light">Connect with your friends and chat about movies!</p>


                        </div>

                        {/*LAST COLUMN */}
                        <div className="col-sm text-center">
                        </div>
                    </div>
                </div>


            </main>
        );
    }
}

export default Navigation