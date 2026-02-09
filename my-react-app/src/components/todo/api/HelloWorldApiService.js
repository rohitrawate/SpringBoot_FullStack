import {apiClient} from "./ApiClient"

export function retrieveHelloWorldBean() {
    // return  axios.get('http://localhost:8081/hello-world-bean')    // returns promise
    return apiClient.get('/hello-world-bean');
}

// export const  retrieveHelloWorldBean 
//      = () => axios.get('http://localhost:8081/hello-world')    // returns promise

export const retrieveHelloWorldPathVariable 
        // = (username) => axios.get(`http://localhost:8081/hello-world/path-variable/${username}`);
        = (username, token) => apiClient.get(`/hello-world/path-variable/${username}`,
            // {
            //     headers: {
            //         Authorization: token
            //     }
            // }
        );
// Without header : has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.Understand this error
//  Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.

