import React from 'react';
import {Link} from 'react-router-dom';


class SignedInButton extends React.Component {
    render() {

        if(false) {
            return (
                        <a onclick="signOut()" className="nav-link" href="/">SIGN OUT</a>
                    )}
        else {
            return (
                        <a className="nav-link" href="SignIn">SIGN IN</a>
                    )}

    }
}

export default SignedInButton