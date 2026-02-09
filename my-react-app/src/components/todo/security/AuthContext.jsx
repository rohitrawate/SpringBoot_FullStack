import { createContext, use, useContext, useState } from "react";
import { executeBasicAuthenticationService, executeJwtAuthenticationService } from "../api/AuthenticationApiService";
import { apiClient } from "../api/ApiClient";

//1:Create a Context for Authentication
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);  // useAuth Hook to access the values in AuthContext easily
// const authContext = useContext(AuthContext);    


//2: Share the context to all the components that need it // Share that state from the context instead of maintaining it in each component

export default function AuthProvider( {children} ) { 
    //3:Put some state in the context
    // const [number, setNumber] = useState(10);

    const [isAuthenticated, setAuthenticated] = useState(false);
    
    const [username, setUsername] = useState(null);

    const [token, setToken] = useState(null);
    // function login(username, password) { 
    //     if(username === 'in28minutes' && password === 'dummy') {
    //         setAuthenticated(true);
    //         setUsername(username);
    //         return true;
    //     } else {
    //         setAuthenticated(false);
    //         setUsername(null);
    //         return false;
    //     }
    // }

    //  async coz this function need to wait for the function executeBasic... to return teh promise
    // async function login(username, password) { 

    //     const baToken = 'Basic ' + window.btoa(username + ":" + password)

    //     //  The  line below are called promise || Doesn't wait to return promise
    //     try{
          
    //         const response = await executeBasicAuthenticationService(baToken)
            
    //         if(response.status == 200) {
    //             setAuthenticated(true)
    //             setUsername(username)
    //             setToken(baToken)

    //             apiClient.interceptors.request.use(
    //                 (config) => {                        // Axios request configuration object
    //                     console.log('intercepting and adding a token')
    //                     config.headers.Authorization = baToken
    //                     return config
    //                 }
    //             )
                
    //             return true;
    //         } else {
    //             logout()
    //             return false;
    //         }
    //     }  catch(error) {
    //         logout()
    //         return false
    //     }
        
    // }

    async function login(username, password) { 

        try{
            const response = await executeJwtAuthenticationService(username, password)
            
            if(response.status == 200) {
                const jwtToken = 'Bearer '+ response.data.token

                setAuthenticated(true)
                setUsername(username)
                setToken(jwtToken)

                apiClient.interceptors.request.use(
                    (config) => {                        // Axios request configuration object
                        console.log('intercepting and adding a token')
                        config.headers.Authorization = jwtToken
                        return config
                    }
                )
                
                return true;
            } else {
                logout()
                return false;
            }
        }  catch(error) {
            logout()
            return false
        }
        
    }

    function logout() {
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
    }

    // const valueToBeShared = { number, isAuthenticated, setAuthenticated };
    return (
    <AuthContext.Provider value={ {  isAuthenticated , login, logout, username, token } }>
            {children}
        </AuthContext.Provider>

    )
}
