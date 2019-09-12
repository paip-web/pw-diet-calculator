/**
 * Redux Reducer Interface
 * @author Patryk Adamczyk <patrykadamczyk@patrykadamczyk.net>
 * @copyright Patryk Adamczyk © 2019
 */
import ActionInterface from './ActionInterface';
/**
 * Redux Reducer Interface
 */
export default interface ReducerInterface
{
    /**
     * Redux Reducer Function
     * @param {object} state State
     * @param {ActionInterface} action Redux Action
     * @returns {any} Changed State
     */
    (state: object, action: ActionInterface): any
}
