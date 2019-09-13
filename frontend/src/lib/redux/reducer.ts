/**
 * Redux Reducer
 * @author Patryk Adamczyk <patrykadamczyk@patrykadamczyk.net>
 * @copyright Patryk Adamczyk © 2019
 */
import ActionInterface from './ActionInterface';
import ReducerInterface from './ReducerInterface';
/**
 * Redux Reducer
 * @param {string} actionType Type of Action which this reducer is for
 * @param {object} state Base State
 * @param {ActionInterface} action Action
 * @param {ReducerInterface} reducer Reducer function to process data
 * @returns {any} New State
 */
export default function(actionType: string, state: object, action: ActionInterface, reducer: ReducerInterface) : any {
    if (action.type === actionType) {
        return reducer(state, action);
    } else {
        return state;
    }
};
