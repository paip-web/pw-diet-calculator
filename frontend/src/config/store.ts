/**
 * Redux Store
 * @author Patryk Adamczyk <patrykadamczyk@patrykadamczyk.net>
 * @copyright Patryk Adamczyk © 2019
 */
import { createStore } from 'redux';
import reduxConfig from './reduxConfig';

/**
 * Redux Store
 */
export default createStore(
    reduxConfig.reducers,
    // @ts-ignore
    reduxConfig.initialState,
    reduxConfig.middlewares
);
