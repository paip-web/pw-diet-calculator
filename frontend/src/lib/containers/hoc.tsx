import { connect } from 'react-redux';
import { withRouter } from 'react-router';
import ActionInterface from '../redux/ActionInterface';
import React from 'react';

type mapStateFuncType = (state: object) => object;
type dispatchType = (action: ActionInterface) => any;
type mapDispatchFuncType = (dispatch: dispatchType) => object;

const appProps = {
};

function mapStateToProps(state: any, mapState: mapStateFuncType | null) {
    const appState = {
    };
    if (mapState !== null) {
        const mappedState = mapState(state);
        return {
            ...appState,
            ...mappedState,
        };
    }
    return appState;
}

function mapDispatchToProps(dispatch: dispatchType, mapDispatch: mapDispatchFuncType | null) {
    const appDispatch = {
    };
    if (mapDispatch !== null) {
        const mappedDispatch = mapDispatch(dispatch);
        return {
            ...appDispatch,
            ...mappedDispatch,
        };
    }
    return appDispatch;
}

export default (
    extraProps: any = {},
    mapState: mapStateFuncType | null = null,
    mapDispatch: mapDispatchFuncType | null = null,
    // @ts-ignore
) => (Component: any) => withRouter(connect(
        (dispatch: dispatchType) => mapStateToProps(dispatch, mapState),
        (dispatch: dispatchType) => mapDispatchToProps(dispatch, mapDispatch),
    )((props: any) => {
        const newProps = {
            ...props,
            ...extraProps,
            ...appProps,
            params: ((props || {}).match || {}).params || {},
        };

        return <Component {...newProps} />;
    }));
