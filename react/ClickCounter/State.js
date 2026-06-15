import React, { useState } from 'react';

function CounterButton(){
    // 1. Create a state variable count and a function to update it
    const [count, setCount] = useState(0);

    return (
        <div>
            <p>You clicled me {count} times </p>
            <button onClick={() => setCount(count+1)}>
                Click me
            </button>
        </div>
    );
}
export default CounterButton;