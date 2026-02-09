import { Link } from "react-router-dom"; 
import { useContext } from "react";
import { AuthContext, useAuth } from "./security/AuthContext.jsx";   // IN { AuthConext }  curly braces bcoz it is not default export

function  HeaderComponent() {

    // const { number } = useContext(AuthContext);
    // const auth_Contexts = useContext(AuthContext);
    
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;

    function logout() {
        // authContext.setAuthenticated(false);
        authContext.logout();
    }

    // console.log("Auth COntect:"+ auth_Contexts + ` number is ${number}`);
    // console.log("Auth COntect:"+ authContext + ` number is ${authContext.number}`);  
    console.log("Auth Context:", authContext);
    /* AuthContext = {
                Provider,
                Consumer
                }    
    */

    // console.log("HeaderComponent - number from context: " + number);
    // console.log("===---- : " + auth_Contexts.number);

    return (
               <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="https://www.in28minutes.com">in28minutes</a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item fs-5">
                                   {isAuthenticated && 
                                        <Link className="nav-link" to="/welcome/Rohitt">Home</Link> }  
                                         {/*  to="/welcome/in28minutes" */}
                                </li>
                                <li className="nav-item fs-5">
                                    {isAuthenticated && 
                                            <Link className="nav-link" to="/todos">Todos</Link> }
                                </li>
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            <li className="nav-item fs-5">
                               { !isAuthenticated && 
                                    <Link className="nav-link" to="/login">Login</Link> }
                            </li>
                            <li className="nav-item fs-5">
                                { isAuthenticated && 
                                    <Link className="nav-link" to="/logout" onClick={logout}>Logout</Link> }
                                </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>

    )
}

export default HeaderComponent;