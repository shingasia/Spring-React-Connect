import React from 'react';
import {BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import MainPage from "./routes/club/MainPage";
import LoginPage from "./routes/member/LoginPage";
import JoinPage from "./routes/member/JoinPage";
import DeletePage from "./routes/member/DeletePage";


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path={["/", "/main"]}>
            <MainPage />
          </Route>
          <Route exact path={"/member/login"} component={LoginPage} />
          <Route exact path={"/member/join"} component={JoinPage} />
          <Route exact path={"/member/delete"} component={DeletePage} />
          <Route path={"/member/*"} component={LoginPage} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
