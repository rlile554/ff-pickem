import React from 'react';
import ReactDOM from 'react-dom';
import renderer from 'react-test-renderer';

import Position from './Position';

describe('Position', () => {
    const props  = {
        name: "Bob Guy",
        position: "QB",
        locked: true,
        points: 123
    };

    it('renders without crashing', () => {
        const div = document.createElement('div');
        ReactDOM.render(<Position {...props} />, div);
        ReactDOM.unmountComponentAtNode(div);
    });

    it('to match snapshot', () => {
        const component = renderer.create(<Position {...props} />);
        let tree = component.toJSON();
        expect(tree).toMatchSnapshot();
    });

    it('renders name prop', () => {
        const component = renderer.create(<Position {...props} />);
        let tree = component.toJSON();
        const nameDiv = tree.children.find(item => item.props.id === 'name');
        expect(nameDiv.children[0]).toEqual(props.name);
    });

    it('renders position prop', () => {
        const component = renderer.create(<Position {...props} />);
        let tree = component.toJSON();
        const nameDiv = tree.children.find(item => item.props.id === 'position');
        expect(nameDiv.children[0]).toEqual(props.position);
    });

    it('renders points prop', () => {
        const component = renderer.create(<Position {...props} />);
        let tree = component.toJSON();
        const nameDiv = tree.children.find(item => item.props.id === 'points');
        expect(nameDiv.children[0]).toEqual(props.points.toString());
    });

    it('shows the lock icon when the locked prop is true', () => {
        const component = renderer.create(<Position {...props} />);
        let tree = component.toJSON();
        const nameDiv = tree.children.find(item => item.props.id === 'iconDiv');
        expect(nameDiv.children.length).toEqual(1); 
    });

    it('does not shows the lock icon when the locked prop is false', () => {
        const component = renderer.create(<Position />);
        let tree = component.toJSON();
        const nameDiv = tree.children.find(item => item.props.id === 'iconDiv');
        expect(nameDiv.children).toBeNull();
    })
});