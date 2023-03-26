import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavBar.js';
import { Container } from 'reactstrap';


const logo = require('./illustration-accountant.jpg');

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <div className="App">
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo" />
                    </header>
                </div>
            </div>
        );
    }
}
export default Home;