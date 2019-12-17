import React from 'react';
import ReactDOM from 'react-dom';
import renderer from 'react-test-renderer';

import WeekCard from './WeekCard';

describe('WeekCard', () => {
    it('renders without crashing', () => {
        const div = document.createElement('div');
        ReactDOM.render(<WeekCard weekNumber={1}/>, div);
        ReactDOM.unmountComponentAtNode(div);
    });

    it('matches the snapshot', () => {
        const component = renderer.create(<WeekCard weekNumber={1} points={12345} />);
        const tree = component.toJSON();
        expect(tree).toMatchSnapshot();
    });
});