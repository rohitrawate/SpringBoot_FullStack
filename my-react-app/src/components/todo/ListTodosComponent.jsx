import { useEffect, useState } from "react";
import { deleteTodoApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

function ListTodosComponent() {
    
    const today = new Date();

    const authContext = useAuth();
    const username = authContext.username;

    const navigate = useNavigate();

    const targetDate = new Date(today.getFullYear()+1, today.getMonth(), today.getDay());

    const [todos, setTodos] = useState([]); // empty state todos array

    const [message, setMessage] = useState();

    // const todos = [
        // {id: 1, description: 'Learn React', done:false, targetDate: targetDate},
        // {id: 2, description: 'Learn Full Stack Development', done:false, targetDate: targetDate},
        // {id: 3, description: 'Learn Microservices', done:false, targetDate: targetDate},
    // ];

    useEffect( () => refreshTodos() , [] );  // empty dependency array means this useEffect runs only once after initial rendering

    function refreshTodos() {

        retrieveAllTodosForUsernameApi(username)
            .then( (response) => {  
                console.log(response.data);
                setTodos(response.data);
            })
            .catch( (error) => {
                console.log(error);
            } )
    }  
    
    function deleteTodo(id) {
        console.log("deleted todo "+ id);
        deleteTodoApi(username, id)
            .then( (response) => {
                console.log(response);
                // Display the message "Delete Successful"
                setMessage(`Deleted todo number ${id} Successful`);
                refreshTodos(); // to refresh the list after deletion
            })
            .catch( (error) => { console.log(error); } )
            .finally( () => {  console.log("cleanup if any");  })
    }

    function updateTodo(id) {
        console.log("update todo "+ id);
        navigate(`/todos/${id}`);
    }

    function addNewTodo() {
        navigate('/todos/-1')
    }

    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            { message && <div className="alert alert-warning">{message}</div> }
            <div>
                 Todo details
                 <table className="table">
                    <thead>
                        <tr>
                            {/* <td>id</td> */}
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {   todos.map(
                                (todo) => (
                                    <tr key={todo.id}>
                                        {/* <td>{todo.id}</td> */}
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate.toString()}</td>  {/*2036-01-29
                                        {/* <td>{new Date(todo.targetDate).toDateString()}</td>   */}{/* Tue Jan 29 2036 */}
                                        <td><button className="btn btn-warning" onClick={ 
                                            () => deleteTodo(todo.id)}>Delete</button></td>
                                        <td><button className="btn btn-success" onClick={
                                            () => updateTodo(todo.id)}>Update</button></td>    
                                    </tr>
                                )
                            )
                        }
                        
                    </tbody>
                 </table>
            </div>
            <div><button className="btn btn-success " onClick={addNewTodo}>Add New Todo</button>
            </div>
        </div>
    )
}

export default ListTodosComponent;