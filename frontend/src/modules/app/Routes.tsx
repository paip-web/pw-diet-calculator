import React from 'react';
import {
    Route,
} from 'react-router-dom';
import App from './containers/App';


export default class Routes extends React.Component {
    render() {
        return (
            <React.Fragment>
                <Route exact path="/" component={App} />
            </React.Fragment>
        );
    }
}
