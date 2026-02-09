import FirstComponent from './FirstComponent'
import {FifthComponent} from './FirstComponent'
import SecondComponent from './SecondComponent'
import ThirdComponent from './ThirdComponent'
import FourthComponent from './FourthComponent'
import { useState } from 'react'

function LearningComponent() {
    return (
        <div className="LearningComponent"> 
           <FirstComponent> </FirstComponent>
           <SecondComponent/>
           <ThirdComponent/>
           <FourthComponent/>
           <FifthComponent/>
        </div>
    );
}

export default LearningComponent;