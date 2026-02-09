import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService";
import { Formik, Form, Field, ErrorMessage } from "formik";
import moment from 'moment';

function TodoComponent() {

    const { id } = useParams();

    const [currentTime, setCurrentTime] = useState(new Date());

    const authContext = useAuth();

    const navigate = useNavigate();

    const [ description, setDescription ] = useState('');

    const [targetDate, setTargetDate ] = useState('')
    const username = authContext.username;

    // Want this to be changes only when the id values changes
    // useEffect( () => loadTodo() , [id] );  

    useEffect(() =>  retrieveTodos() , [id]);
    // useEffect(() => {  loadTodo(); }, [id]);


    // retrieveTodos
    function retrieveTodos() {

        if( id != -1) {
            retrieveTodoApi(username, id)
                .then( response => {
                    // console.log(response);
                    setDescription(response.data.description);
                    setTargetDate(response.data.targetDate)
                })
                .catch( error => console.log(error) );
            console.log("retrieve todo");
        }
    }

    function onSubmit(values) {
        console.log(values)
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }
        console.log(todo)

        if( id ==-1){
            createTodoApi(username, todo)
                .then( response => {
                    console.log(response)
                    navigate('/todos')
                })
        }else {
            updateTodoApi(username, id, todo)
                .then( response => {
                    // setDescription(response.data.description)
                    // setTargetDate(response.data.targetDate)
                    console.log(response)
                    navigate('/todos')
                })
                .catch(error => console.log(error))
        }        
    }

    function validate(values){
        let errors = {
            // description: 'Enter a valid description',
            // targetDate: 'Enter a valid target date'
        }

        // if (!values.description || values.description.length < 5) {
        if ( values.description.length < 5) {
            errors.description = "Enter atleast 5 charaters";
        }
        console.log("currentTime : "+ currentTime.getDate())
        
        if( values.targetDate == null || values.targetDate == ''|| !moment(values.targetDate).isValid) {   // values.targetDate < currentTime
            errors.targetDate = 'Enter a valid target Date'
        }

        console.log(values)
        return errors
    }

    return (
        <div>
            {/* <h1>Todo Component</h1> */}
            <div className="container">
                {/* <ListTodosComponent /> */}
                <h1>Enter Todo Details</h1>
                <div>
                    {/* description : {description} */}
                    {/* <Formik>    accepts function and so it   is inside the  open{  closed}          
                    2. The intial values of the descrp and date is picled up from the useSate('') so which i empty and we need to re initialiazed again which formik does not do : So, configure Formik  */}
                    <Formik initialValues={ { description, targetDate} } // default data initail values in state('') : empty
                            enableReinitialize= {true}  // update form after API call
                            onSubmit={ onSubmit }
                            validate={ validate }
                            validateOnChange = {false}
                            validateOnBlur = {false}
                            validateOnMount={true}   // Show error on page load (BEST for edit forms)
                    >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <ErrorMessage
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description"/>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate"/>
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                    </Formik>
                </div>
            </div>
        </div>
    );
}

export default TodoComponent;