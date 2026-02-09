import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

function LoginComponent() {

    const [username, setUsername] = useState('in28minutes');

    const [password, setPassword] = useState('');

    // const [showSuccessMessage, setShowSuccessMessage] = useState(false);

    const [showErrorMessage, setShowErrorMessage] = useState(false);

    const navigate = useNavigate()
    
    const authContext = useAuth()


    function handleUsernameChange(event) {
        // console.log(event.target.value);
        // setUsername(event.target.value);
        setUsername((username) => event.target.value);
    }

    function handlePasswordChange(event) {
        // console.log(event.target.value);  // Character by letter 
        setPassword(event.target.value);    
    }
  
    async function handleSubmit() {      // Triggers the state change of the ShowSuccessMsg/ErrorMsg
        // console.log("Login button clicked");
        if( await authContext.login(username, password) ) {
            // setShowSuccessMessage(true)    // These messages dono really matter anymore as we are 
            // setShowErrorMessage(false)      // navigating to another page on success
            navigate(`/welcome/${username}`);
        } else{
            // setShowSuccessMessage(false)
            setShowErrorMessage(true)
        }
    }

    // function SuccessMessageComponent(){
        
    //     if(showSuccessMessage){
    //         return <div className="successMessage">---*** Authenticated Successfully ***---</div>
    //     }
    //     return null;
    // }
    // function ErrorMessageComponent() {
    //     if(showErrorMessage) {
    //         return <div className="errorMessage">Authentication Failed. Please check your credentials.</div>
    //     }
    //     return null;
    // }


    return (
        <div className="Login">
            <h1>Login Time!!!</h1>
            {/* { showSuccessMessage && <div className="successMessage">---*** Authenticated Successfully ***---</div> } */}
            { showErrorMessage && <div className="errorMessage">Authentication Failed.
                                        Please check your credentials.</div> }
            {/* <SuccessMessageComponent/> */}
            {/* <ErrorMessageComponent/> */}
            <div className="LoginForm">
                <div>
                    <label>UserName: </label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" name="password" placeholder="Pa$$word" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" className="btn" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}

export default LoginComponent;