import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const Container = styled.div`
    width: 100%;
    background-color: #d8d8d8;
    border: 1px solid #979797;
    height: 50px;
    display: flex;
    justify-content: space-between;
    color: #535353;
`;

const Nav = styled.ul`
    list-style-type: none;
    margin: 0;
    padding: 0;
    display: flex;
`;

const NavLink = styled.li`
    float: left;
    border-right: 1px solid black;
    width: 100px;
    height: 50px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #535353;
    font-weight: bold;
    &:hover {
        background-color: #9B9B9B;
        color: white;
    };
`;

const UserInfo = styled.div`
    display: flex;
    padding-right: 8px;
`;

const Name = styled.div`
    font-size: 36;
    font-weight: bold;
    align-self: center;
`;

const Header = props => {
    return (
        <Container>
            <Nav>
                <Link to="/"><NavLink selected>My Team</NavLink></Link>
                <Link to="/league"><NavLink>League</NavLink></Link>
            </Nav>
            <UserInfo>
                <Name>Ryan Lile</Name>
            </UserInfo>
        </Container>
    );
};

export default Header;
