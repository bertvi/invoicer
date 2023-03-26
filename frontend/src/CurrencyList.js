import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar.js';
import { Link } from 'react-router-dom';

class CurrencyList extends Component {

    constructor(props) {
        super(props);
        this.state = {currencies: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/currencies')
            .then(response => response.json())
            .then(data => this.setState({currencies: data}));
    }

    async remove(id) {
        await fetch(`/api/currencies/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCurrencies = [...this.state.currencies].filter(i => i.id !== id);
            this.setState({currencies: updatedCurrencies});
        });
    }

    render() {
        const {currencies, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const currenciesList = currencies.map(currency => {
            return <tr key={currency.id}>
                <td style={{whiteSpace: 'nowrap'}}>{currency.name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/currencies/" + currency.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(currency.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/currencies/new">Add Currency</Button>
                    </div>
                    <h3>Currencies</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {currenciesList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default CurrencyList;