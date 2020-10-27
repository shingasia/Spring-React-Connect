import React from 'react';
import axios from "axios";

class DeleteForm extends React.Component {


    constructor(props){
        super(props);

        this.state = {
            delete_success:false,
            id:'',
            password:''
        };

    }

    idChange = e => {
        this.setState({
            id: e.target.value
        });
    }

    passwordChange = e => {
        this.setState({
            password: e.target.value
        });
    }


    handleSubmit = e => {
        e.preventDefault();

        const user = {
            id:this.state.id,
            password:this.state.password
        };

        axios.post('http://localhost:8182/union_club_w-1.0-SNAPSHOT/member/deletemember', user).then(res => {
            console.log(res);
            console.log(res.data);
            if(!('message' in res.data)){
                this.setState({delete_success:true});
            }else{
                alert(res.data.message);
            }
        }).catch(err => {
            console.log(err);
        })
    }


    render(){

        const {delete_success, id, password} = this.state;
        const {goToLogin} = this.props;

        if(delete_success){
            goToLogin();
        }

        return (
            <>
                <form onSubmit={this.handleSubmit} className="Delete-Form">
                    <label>
                        ID:
                        <input type="text" value={id} onChange={this.idChange} />
                    </label><br/>
                    <label>
                        PASSWORD:
                        <input type="password" value={password} onChange={this.passwordChange} />
                    </label><br/>

                    <input type="submit" value="탈퇴" />
                </form>
            </>
        )

    }
}

export default DeleteForm;