import React from "react";
import axios from "axios";

class JoinForm extends React.Component {


    constructor(props){
        super(props);

        this.state = {
            join_success:false,
            id:'',
            password:'',
            confirmpassword:'',
            name:'',
            address:'',
            email:''
        };
        
    }

    // handleChange = (e) => { this.setState({ [e.target.name]: e.target.value }); }
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
    confirmpasswordChange = e => {
        this.setState({
            confirmpassword: e.target.value
        });
    }
    nameChange = e => {
        this.setState({
            name: e.target.value
        });
    }
    addressChange = e => {
        this.setState({
            address: e.target.value
        });
    }
    emailChange = e => {
        this.setState({
            email: e.target.value
        });
    }



    handleSubmit = event => {
        event.preventDefault();

        const member = {...this.state};

        // "https://jsonplaceholder.typicode.com/posts"
        // "http://localhost:8182/union_club_w-1.0-SNAPSHOT/member/joinmember"
        axios.post("http://localhost:8182/union_club_w-1.0-SNAPSHOT/member/joinmember", {member}).then(res => {
            console.log(res);
            console.log(res.data); // message: "Please check your information..."
            if(!("message" in res.data)){ // 에러가 발생하지 않으면
                this.setState({join_success:true, ...res.data});
            }else{ // 에러가 발생하면
                alert(res.data.message);
            }
        }).catch((error) => {
            console.log("ERROR"+error.message);
            this.setState({join_success:false});
        });

    }

    render(){

        const {join_success, id, password, confirmpassword, name, address, email} = this.state;
        const {goToLogin} = this.props;

        if(join_success){ // 가입 성공했으면 URL 이동
            // window.location.href="/member/login"; //이거 말고 다른 방법 없을까???
            goToLogin();
        }

        return (
            <>
                <form onSubmit={this.handleSubmit} className="Join-Form">
                    <label>
                        ID:
                        <input placeholder="아이디 입력하라 마!" type="text" name="id" value={id} onChange={this.idChange} />
                    </label><br/>

                    <label>
                        PASSWORD:
                        <input placeholder="비번 입력하라 마!" type="password" name="password" value={password} onChange={this.passwordChange} />
                    </label><br/>

                    <label>
                        CONFIRM-PASSWORD:
                        <input placeholder="비번 확인 입력하라 마!" type="password" name="confirmpassword" value={confirmpassword} onChange={this.confirmpasswordChange} />
                    </label><br/>

                    <label>
                        NAME:
                        <input placeholder="이름 입력하라 마!" type="text" name="name" value={name} onChange={this.nameChange} />
                    </label><br/>

                    <label>
                        ADDRESS:
                        <input placeholder="주소 입력하라 마!" type="text" name="address" value={address} onChange={this.addressChange} />
                    </label><br/>

                    <label>
                        E-Mail:
                        <input placeholder="이메일 입력하라 마!" type="text" name="email" value={email} onChange={this.emailChange} />
                    </label><br/>

                    <input type="submit" value="확인"/>
                    <input type="reset" value="취소"/>
                </form>
            </>
        )
    }
}

export default JoinForm;