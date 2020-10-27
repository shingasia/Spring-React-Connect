import React from "react";
import axios from 'axios';

class LoginForm extends React.Component {

    constructor(props){
        super(props);

        this.state = {login_success:false, id:'', password:''};

        this.idChange=this.idChange.bind(this);
        this.passwordChange=this.passwordChange.bind(this);
        // this.handleChange=this.handleChange.bind(this);
    }

    //모든 input 제어 1
    // handleChange = e => { 
    //     const { name, value } = e.target; 
    //     this.setState({ 
    //         [name]: value 
    //     }); 
    // };

    //모든 input 제어 2
    // handleChange = (event) => {
    //     this.setState({[event.target.name]: event.target.value});

    //     console.log("id"+" = "+this.state.id);
    //     console.log("pw"+" = "+this.state.password);
    // }

    idChange(event){
        this.setState({
            id: event.target.value 
        });
    }

    passwordChange(event){
        this.setState({
            password: event.target.value
        });
    }

    handleSubmit = event => {
        event.preventDefault();

        const user = {
            id: this.state.id,
            password: this.state.password
        };

        // axios.post(`https://localhost:8182/~~~~`, {user}).then(res => {
        //     console.log(res);
        //     console.log(res.data);
        // });

        axios.post("http://localhost:8182/union_club_w-1.0-SNAPSHOT/member/loginmember", user).then(res => {
            console.log(res);
            console.log(res.data); // message: "Please check your information..."
            if(!("message" in res.data)){ //로그인 성공하면
                this.setState({login_success:true});
            }else{
                alert(res.data.message);
            }
        }).catch(err => {
            console.log(err);
        });

        // axios.post("https://jsonplaceholder.typicode.com/posts", user)
        // .then(res => console.log(res))
        // .catch(err => console.log(err));
    }

    render(){
        const {login_success, id, password} = this.state;
        const {goToMain} = this.props;

        if(login_success){
            goToMain(id);
        }

        return (
            <>
                <form onSubmit={this.handleSubmit} className="Login-Form">
                    <label>
                        ID:
                        <input placeholder="아이디 입력하라 마!" type="text" value={id} onChange={this.idChange} />
                    </label><br/>
                    <label>
                        PASSWORD:
                        <input placeholder="비번 입력하라 마!" type="password" value={password} onChange={this.passwordChange} />
                    </label><br/>

                    <input type="submit" value="확인"/>
                </form>
                
            </>
        );
    }

}

export default LoginForm;