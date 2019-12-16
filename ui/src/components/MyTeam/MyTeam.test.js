import React from 'react';
import ReactDOM from 'react-dom';

import MyTeam from './MyTeam';

describe('MyTeam', () => {
    it('renders without crashing', () => {
        const div = document.createElement('div');
        ReactDOM.render(<MyTeam />, div);
        ReactDOM.unmountComponentAtNode(div);
    });
});