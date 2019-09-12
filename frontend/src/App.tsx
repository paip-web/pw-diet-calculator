import React from 'react';
import {
    HashRouter as Router,
    Switch,
} from 'react-router-dom';
import { Provider } from 'react-redux';
import modules from './config/modules.json';
import store from './config/store';


export default class App extends React.Component {
    static getAllModules(): string[] {
        return ['app', ...modules];
    }
    importRoutes() {
        return App.getAllModules().
            map(module => (
                require(`./modules/${module}/Routes.tsx`).default
            ));
    }
    render() {
        const routes = this.importRoutes();
        return (
            <Provider store={store}>
                <Router>
                    <Switch>
                        {routes.map((Route, i) => <Route key={App.getAllModules()[i]}/>)}
                        {/*<Route exact path="/404" component={NotFoundError} />*/}
                        {/*<Redirect from="*" to="/404" />*/}
                    </Switch>
                </Router>
            </Provider>
        );
    }
}
