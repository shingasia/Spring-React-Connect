import React from "react";
import { Link } from "react-router-dom";
import DeleteForm from "../../components/member/DeleteForm";

function DeletePage(props){

    const {location, match, history} = props;
    const goToLogin = () => {
        history.push("/member/login");
    }
    return (
        <>
            회원 탈퇴 페이지
            <DeleteForm goToLogin = {goToLogin}/>
            
        </>
    );
}

export default DeletePage;

