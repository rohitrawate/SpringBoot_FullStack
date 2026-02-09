// import PropTypes from 'prop-types';
// import React, { useState } from 'react';

export default function CounterButton( {by, incrementParentMethod, decrementMethod} ) {

    //useState returns -> [0, ƒ] = [initialValue, updaterFunction] *********
    // const [count, setCount] = useState(0);       // -- REmoved state from the child component

    console.log(by);    

    /*
    function incrementCounterCount() {
        // state[0] = state[0] + 1;
        // setCount(count + by);
        // console.log("incrementCounterCount called: "+ count)
        incrementParentMethod(by)
    }

    function decrementCounterCount() {
        // state[0] = state[0] - 1;
        // setCount(count - by);
        // incrementParentMethod(-by)
        decrementMethod(by)
    }
        */

    return (
        <div className="Counter">
            {/* / Not needed as count is maintained at parent level */}
            {/* <span className="count" >{count}</span> */}   
            {/* style={{fontSize:"30px"}} */}
            <div>
                <button className="counterButton" 
                        // onClick={incrementCounterCount} 
                        onClick={()=> incrementParentMethod(by)} 
                        // style={buttonStyle}
                
                >+{by}</button>
                <button className="counterButton" 
                        // onClick={decrementCounterCount} 
                        onClick={() => decrementMethod(by)} 
                
                >-{by}</button>
            </div>
        </div>
    )
}

// Proptypes validation -> Install 'prop-types' package first
// CounterButton.propTypes = {
//     by: PropTypes.number
// }

// CounterButton.defaultProps = {
//     by: 1
// }
// export default CounterButton;