import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Component } from 'react'
// import LearniningJavaScript from './components/learning-examples/LearningJavaScript'
import Counter from './components/counter/Counter'
import TodoApp from './components/todo/TodoApp'

function App() {
  // const [count, setCount] = useState(0)
  return (
    <div className="App">
        {/* My TO-DO LIST */}
      {/* <PlayingWithProps property1="value7" property2="value909"/> */}
      {/* <Counter/> */}
      <TodoApp/>
    </div>
  );
}

// {property1: 'value1', property2: 'value2'}
// function PlayingWithProps(properties) {
//   console.log("Properties received in PlayingWithProps component: ", properties);
//   console.log(properties.property1);
//   console.log(properties.property2);
//   return (
//     <div>Props</div>
//   )
// }

function PlayingWithProps( {property1, property2} ) { // deconstruction
  console.log(property1);
  console.log(property2);
  return (
    <div>Props</div>
  )
}

export default App
