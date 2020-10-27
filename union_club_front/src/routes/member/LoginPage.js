import React from "react";
import { Link } from "react-router-dom";
import LoginForm from "../../components/member/LoginForm";

function LoginPage(props){

    // console.log(props.location);
    // console.log(props.match);
    // console.log(props.history);

    const {location, match, history} = props;

    const goToMain = (id) => {
        history.push("/"+"?id="+id);
    }

    const goToJoin = () => {
        history.push("/member/join");
    }
    const goToModify = () => {
        history.push("/member/modify");
    }

    return (
        <React.Fragment>
            로그인 페이지입니다.
            <p>로케이션 {location.pathname}</p>
            <p>해시 {location.hash}</p>

            <p>패스 {match.path}</p>
            <p>유알엘 {match.url}</p>
            <p>파라미터 {JSON.stringify(match.params)}</p> {/* club/:clubname/:introduce */}
            <p>쿼리 {location.search}</p>
            <LoginForm goToMain={goToMain} />
            <hr/>
            <button onClick={goToJoin}>회원 가입</button>
            <button onClick={goToModify}>비밀번호 변경</button><br/>
            <Link to="/member/delete">회원 탈퇴</Link>
        </React.Fragment>
    );
}

export default LoginPage;