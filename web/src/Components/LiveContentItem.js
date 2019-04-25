import React, { Component } from 'react';

class LiveContentItem extends Component {

    render() {
        return <div className="card border-secondary live-content">
            <div className="card-header">{this.props.airTime}</div>
            <div className="card-body">
                <h5 className="card-title">{this.props.channel}</h5>
                <p className="card-text">{this.props.item}</p>
            </div>
        </div>
    }
}

export default LiveContentItem
