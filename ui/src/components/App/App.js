import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

import Header from '../Header/Header';
import MyTeam from '../MyTeam/MyTeam';
import League from '../League/League';

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Header />
                <Switch>
                  <Route exact path="/" component={MyTeam} />
                  <Route path="/league" component={League} />
                </Switch>
            </div>
        </BrowserRouter>
    );
}

export default App;
