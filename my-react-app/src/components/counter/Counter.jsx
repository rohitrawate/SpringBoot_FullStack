import { useState } from 'react'; 
import './Counter.css';
import CounterButton from './CounterButton';

export default function Counter() {       // Parent Component
    const [count, setCount] = useState(0);   // COunt maintained at the Counter level

    function incrementCounterParentFunction(by) {
        setCount(count + by)
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by)
    }

    function resetCounter() {
        setCount(0);
    }

    return (
        <>
          <span className="totalcount" >{count}</span>
            <CounterButton by={1} 
                incrementParentMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction}/>
            <CounterButton by={2} 
                incrementParentMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction}/>
            <CounterButton by={5} 
                incrementParentMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction}/>
            {/* <div> */}
                <button className="resetButton" onClick={resetCounter}>Reset</button>
            {/* </div> */}
        </>
    );
}
