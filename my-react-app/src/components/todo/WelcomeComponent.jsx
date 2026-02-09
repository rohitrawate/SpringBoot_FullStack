import { useState } from "react";
import { Link, useParams } from "react-router-dom";
// import { retrieveHelloWorldBean } from "./api/HelloWorldApiService";
import { retrieveHelloWorldBean, retrieveHelloWorldPathVariable } from "./api/HelloWorldApiService";
import { useAuth } from "./security/AuthContext";


function WelcomeComponent() {

    const { username } = useParams(); // to extract the path variable from the URL

    const authContext = useAuth();

    const [message, setMessage] = useState(null);

    // console.log(username);
    function callHelloWorldRestApi() {
        console.log("callHelloWorldRestApi");

        // retrieveHelloWorldBean()
        // axios.get('http://localhost:8081/hello-world')    // returns promise
        // .then( (response) => successfulResponse(response))
        // .catch( (error) => errorResponse(error) )
        // .finally( () => console.log("Cleanup actions if any") );

        // axios.get('http://localhost:8081/hello-world-bean')    // returns promise
        // retrieveHelloWorldBean()
        //         .then( (response) => successfulResponse(response))
        //         .catch( (error) => errorResponse(error) )
        //         .finally( () => console.log("Cleanup actions if any") );


        retrieveHelloWorldPathVariable(username, authContext.token)
                .then( (response) => successfulResponse(response) )
                .catch( (error) => errorResponse(error) )
                .finally( () => console.log("Cleanup actions if any") );
    }

    function successfulResponse(response) {
        console.log(response);
        setMessage(response.data.message);  // When JSON / Object is being passed from Backend
        // setMessage(response.data);       // When String is being passed from Backend   // Error: Objects are not valid as a React child
    }

    function errorResponse(error) {
        console.log(error);
    }   

    return (
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div >
                {/* Welcome to the Todo Management Application! */}
                Manage you todos - <Link to="/todos">Click Here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                        Call Hello World</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}

export default WelcomeComponent;