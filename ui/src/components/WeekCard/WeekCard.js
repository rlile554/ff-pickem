import React from 'react';
import styled from 'styled-components';
import PropTypes from 'prop-types';
import { FiEdit } from 'react-icons/fi';

import Position from './Position';


const Container = styled.div`
    width: 320px;
    height: 340px;
    border: solid 1px #979797;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
`;

const Week = styled.div`
    text-transform: uppercase;
    font-size: 48px;
    font-weight: bold;
`;
const Score = styled.div`
    font-size: 24px;
    fontweight: bold;
`;

const IconDiv = styled.div`
    margin-top: 4px;
    margin-right: 4px;
    align-self: flex-end;
    font-size: 20px;
`;

const PositionContainer = styled.div`
    width: 100%;
`;

const getPointsText = (points) => {
    return points? `points: ${points}` : 'points: 0';
}

const WeekCard = props => {
    const { weekNumber, points } = props;
    return (
        <Container>
            <IconDiv>
                <FiEdit />
            </IconDiv>
            <Week>Week {weekNumber}</Week>
            <Score>{getPointsText(points)}</Score>
            <PositionContainer id="positionsContainer">
                <Position position={'QB'} locked name={"Tom Brady"} points={12345} />
                <Position position={'RB'} name={"Mark Ingram"} points={2233} />
                <Position position={'WR'} name={"Sammie Watkins"} points={323} />
                <Position position={'D'} locked name={"Patriots"} points={1} />
            </PositionContainer>
        </Container>
    );
};

WeekCard.propTypes = {
    weekNumber: PropTypes.number.isRequired,
    points: PropTypes.number
}



export default WeekCard;
