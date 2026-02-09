import { useState } from "react";
import { BrowserRouter, Routes, Route, useNavigate, Navigate } from "react-router-dom";
import './TodoApp.css'
import LogoutComponent from "./LogoutComponent.jsx";
import HeaderComponent from "./HeaderComponent.jsx";
import ListTodosComponent from "./ListTodosComponent.jsx";
import ErrorComponent from "./ErrorComponent.jsx";
import WelcomeComponent from "./WelcomeComponent.jsx";
import LoginComponent from "./LoginComponent.jsx";
import AuthProvider, { useAuth } from "./security/AuthContext.jsx";
import TodoComponent from "./TodoComponent.jsx";


function AuthenticatedRoute( { children } ) { 
    const authContext = useAuth();
    if( authContext.isAuthenticated ) {
        return children;
    } else {
        // return <LoginComponent/>
        return  <Navigate to="/" />;
    }   
}



function TodoApp() {

    return (
        <div className="TodoApp">
            {/* Todo Management Application */}
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/" element={ <LoginComponent/> } />
                        <Route path="/login" element={ <LoginComponent/>  } />

                        <Route path="/welcome/:username" element={
                            <AuthenticatedRoute> 
                                <WelcomeComponent/>
                            </AuthenticatedRoute>    
                        } />

                        <Route path="/todos" element={ 
                            <AuthenticatedRoute>
                                 <ListTodosComponent/> 
                            </AuthenticatedRoute> 
                        } />

                        <Route path="/todos/:id/" element={  // cahnge to /todo/:id
                            <AuthenticatedRoute>
                                 <TodoComponent/> 
                            </AuthenticatedRoute> 
                        } />

                        <Route path="/logout" element={ 
                            <AuthenticatedRoute>
                                <LogoutComponent/> 
                            </AuthenticatedRoute>
                            } />
                        <Route path="*" element={ <ErrorComponent/> } ></Route>
                    </Routes>
                </BrowserRouter>
                
            </AuthProvider>
        </div>
    )
}














export default TodoApp;