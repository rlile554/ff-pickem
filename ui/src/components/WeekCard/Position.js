import React from 'react';
import PropTypes from 'prop-types';
import styled from 'styled-components';

import { FiLock } from 'react-icons/fi';

const Container = styled.div`
    width: 100%;
    height: 50px;
    border-top: 1px solid #979797;
    display: flex;
    align-items: center;
    padding-left: 2px;
`;

const PosDiv = styled.div`
    height: 40px;
    width: 40px;
    border-radius: 50%;
    background-color: #5b5b5b;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    font-weight: bold;
`;

const IconDiv = styled.div`
    width: 25px;
    height: 25px;
    font-size: 20px;
    padding-top: 5px;
`;

const Name = styled.div`
    font-weight: bold;
    width: 180px;
    text-align: center;
`;

const Points = styled.div`
    font-weight: bold;
    text-align: right;
    width: 60px;
`;

const Position = props => {
    const { position, locked, name, points } = props;
    return (
        <Container>
            <PosDiv id="position">{position}</PosDiv>
            <IconDiv id="iconDiv">{locked && <FiLock />}</IconDiv>
            <Name id="name">{name}</Name>
            <Points id="points">{points}</Points>
        </Container>
    );
};

Position.propTypes = {
    //The position of the player
    position: PropTypes.string,
    //wether or not the pick is locked in
    locked: PropTypes.bool,
    //the name of the player
    name: PropTypes.string,
    //the numer of ponts the player currently has
    points: PropTypes.number
};

export default Position;
