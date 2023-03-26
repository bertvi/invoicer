import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar.js';
import { Link } from 'react-router-dom';

class PriceList extends Component {

    constructor(props) {
        super(props);
        this.state = {prices: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/prices')
            .then(response => response.json())
            .then(data => this.setState({prices: data}));
    }

    async remove(id) {
        await fetch(`/api/prices/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedPrices = [...this.state.prices].filter(i => i.id !== id);
            this.setState({prices: updatedPrices});
        });
    }

    render() {
        const {prices, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const pricesList = prices.map(price => {
            return <tr key={price.id}>
                <td style={{whiteSpace: 'nowrap'}}>{price.name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/prices/" + price.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(price.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/prices/new">Add Price</Button>
                    </div>
                    <h3>Prices</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {pricesList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default PriceList;