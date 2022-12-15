import React, { useState } from 'react';
import {Link} from 'react-router-dom';
import '../css/styles.css';
import '../css/bootstrap.css';
import BG from "../images/flecks.png";
import Navbar from '../components/navbar/navbar';
<link rel="preconnect" href="https://fonts.googleapis.com"></link>;
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin></link>;
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat&family=Sacramento&display=swap" rel="stylesheet"></link>;


const Signin  = () => 
{
    const [username, setUsername] = useState("")    
    const [password, setPassword] = useState("")

    const onSubmitForm = async e => {
        // prevents page from refreshing
        e.preventDefault()
        try {
            const body = { username, password }
            
            const response = await fetch("http://localhost:3001/login",{
                 method: "POST",
                 headers: { "Content-Type": "application/json"},
                body: JSON.stringify(body)
            })
            console.log(response)
            
        } catch (err) {
            console.error(err.message)
        }
    }
    return (
      // <body style={{backgroundImage: `url(${MyBackground})`}}>
      <main>
        <Navbar/>
      <body >
        
      <div class="login">
      <form class="form" id="login" onSubmit={onSubmitForm}>
          <h1 class="form__title">Login</h1>
          <div class="form__message form__message--error"></div>
          <div class="form__input-group">
              <input 
                    value={username}
                    onChange={(e) => setUsername(e.target.value)} 
                    className="form__input" 
                    autofocus placeholder="Username"
                />
              <div class="form__input-error-message"></div>
          </div>
          <div class="form__input-group">
                <input 
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} 
                    className="form__input" 
                    autofocus placeholder="Password"
                />
              <div class="form__input-error-message"></div>
          </div>
                
                  <button type="submit" className="btn btn-primary btn form__button">
                  Sign In
                  {/* <Link to="/Navigation" className='btn btn-primary'>Sign In</Link> */}
                  </button>
                  <div className="form__input-error-message"></div>
                  <button  class="btn btn-success form__button" >
                      <Link to="/Signup" className='btn btn-success'>Sign Up</Link>
                  </button>
                  <div className="form__input-error-message"></div>
                  <button type="button" class="btn btn-danger form__button" >
                      <Link to="/ForgotPW" className='btn btn-danger'>Forgot Password</Link>
                  </button>               

              </form>
        </div>
        </body>
    </main>

        );
    }
export default Signin