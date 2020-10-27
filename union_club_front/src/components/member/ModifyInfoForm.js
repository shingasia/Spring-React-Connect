import React from "react";
import axios from "axios";

class ModifyInfoForm extends React.Component {

    constructor(props){
        super(props);

        this.state = {
            modify_success: false,
        }

        
    }

    onChangeHandler(event){
        this.setState({
            [event.target.name] : event.target.value
        });
     }
}