import React from 'react';
import {Link} from 'react-router-dom';
import Logo from '../../images/Logo.png';
import SignedInButton from '../../components/signedinbutton/signedinbutton.js';


class Navbar extends React.Component {
    render() {
        return (
            <main>

                <nav
                    className=" navbar navbar-expand-lg navbar-light bg-warning bg-opacity-100  shadow-lg ">
                    <a className="navbar-brand" href="/">
                        <img src={Logo} alt=""/>
                    </a>
                    <ul className="navbar-nav text">
                        <li className="nav-item">
                            <a className="nav-link" href="/movie-search">SEARCH A MOVIE</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/Cart">CART</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/Chat">CHAT</a>
                        </li>
                        <li className="nav-item">
                            {/*<a className="nav-link" href="Signin">SIGN-IN</a>*/}
                            <SignedInButton/>
                        </li>
                    </ul>

                </nav>

            </main>
        );
    }
}

export default Navbar