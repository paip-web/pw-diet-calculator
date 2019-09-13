/**
 * Redux Configuration
 * @author Patryk Adamczyk <patrykadamczyk@patrykadamczyk.net>
 * @copyright Patryk Adamczyk © 2019
 */
import { applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';

/**
 * Base Configuration
 */
const config = {
    reducers: () => {},
    middleware: [
        thunk
    ],
    initialState: {
    }
};
/**
 * Middlewares
 * This function generates middlewares with Redux DevTools
 * @function middlewares
 * @returns Middlewares with Redux DevTools or without based on config
 */
function middlewares() {
    const reduxDevTools = (
        (window as any).__REDUX_DEVTOOLS_EXTENSION__ &&
        (window as any).__REDUX_DEVTOOLS_EXTENSION__({
            name: "Redux Store",
            trace: true
        })
    ) || null;
    if(reduxDevTools !== null) {
        return compose(
            applyMiddleware(...config.middleware),
            reduxDevTools
        );
    } else {
        return applyMiddleware(...config.middleware);
    }
}

export default {
    ...config,
    middlewares: middlewares()
};
