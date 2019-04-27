import React, { Component } from 'react';
import './App.css';
import LiveContentItem from "./Components/LiveContentItem";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            liveContents: null,
            errorMessage: null
        }
    }

    componentDidMount() {
        fetch(window.location.pathname + "//" + window.location.hostname + ":8080")
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Unable to get the contents');
                }
            })
            .then(data => {
                let liveContents = data.map((liveContent, i) => {
                    return (
                        <LiveContentItem
                            key={i}
                            channel={liveContent.channel}
                            airTime={liveContent.airTime}
                            item={liveContent.item}
                        />
                    )
                })
                this.setState({liveContents: liveContents})
            })
            .catch((error) => {
                this.setState({errorMessage: error.message})
            });
    }

    render() {
        return (
            <div className="App">
                {this.state.errorMessage ||
                 <div className="content-container">
                     {this.state.liveContents}
                 </div>
                }
            </div>
        );
    }

}

export default App;
