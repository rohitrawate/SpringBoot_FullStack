import { useContext } from "react";
import { AuthContext } from "./security/AuthContext";

function  FooterComponent() {

    const authContext = useContext(AuthContext);

    console.log(`FooterComponent: ${authContext.number}`);

    return (
        <footer className="footer">
            <div className="container"> 
                Your Footer
            </div>  
        </footer>
    )
}

export default FooterComponent;