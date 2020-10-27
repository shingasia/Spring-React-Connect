import React from "react";
import JoinForm from "../../components/member/JoinForm";

function JoinPage(props){

    // let [login, setLogin] = useState(false);
    // this.setState와 유사하지만, 이전 state와 새로운 state를 합치지 않는다는 차이가 있다.
    // Hook의 state는 객체일 필요가 없다. 물론 원한다면 그렇게도 가능하다. 이 초기값은 첫 번째 렌더링에만 딱 한번 사용된다.

    const {location, match, history} = props;
    const goToLogin = () => {
        history.push("/member/login");
    }

    return (
        <>
            <p>회원가입 페이지입니다.</p>
            <JoinForm goToLogin={goToLogin} />
        </>
    )
}

export default JoinPage;