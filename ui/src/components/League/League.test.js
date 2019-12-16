import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router} from 'react-router-dom';

import League from './League';

describe('League', () => {
    it('renders without crashing', () => {
        const div = document.createElement('div');
        ReactDOM.render(<League />, div);
        ReactDOM.unmountComponentAtNode(div);
    });
});
