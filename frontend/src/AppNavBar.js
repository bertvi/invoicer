import React, {Component} from 'react';
import {Navbar, NavbarBrand} from 'reactstrap';
import {Link} from 'react-router-dom';

class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
            <NavbarBrand tag={Link} to="/activities">Activities</NavbarBrand>
            <NavbarBrand tag={Link} to="/companies">Companies</NavbarBrand>
            <NavbarBrand tag={Link} to="/units">Units</NavbarBrand>
            <NavbarBrand tag={Link} to="/currencies">Currencies</NavbarBrand>
            <NavbarBrand tag={Link} to="/customers">Customers</NavbarBrand>
            <NavbarBrand tag={Link} to="/invoices">Invoices</NavbarBrand>
            <NavbarBrand tag={Link} to="/prices">Prices</NavbarBrand>
            <NavbarBrand tag={Link} to="/projects">Projects</NavbarBrand>
        </Navbar>;
    }
}

export default AppNavbar;