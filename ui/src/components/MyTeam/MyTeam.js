import React from 'react';
import styled from 'styled-components';

import WeekCard from '../WeekCard/WeekCard';

const Container = styled.div`
    margin: 8px;
`;

const MyTeam = props => {
    return (
        <Container>
            <h1>My Team</h1>
            <WeekCard weekNumber={1} points={12345}/>
        </Container>
    );
};

export default MyTeam;
