import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ActivityList from "./ActivityList.js";
import ActivityEdit from "./ActivityEdit.js";
import UnitList from "./UnitList.js";
import UnitEdit from "./UnitEdit.js";
import CompanyList from "./CompanyList.js";
import CompanyEdit from "./CompanyEdit.js";
import CurrencyList from "./CurrencyList.js";
import CurrencyEdit from "./CurrencyEdit.js";
import CustomerList from "./CustomerList.js";
import CustomerEdit from "./CustomerEdit.js";
import InvoiceList from "./InvoiceList.js";
import InvoiceEdit from "./InvoiceEdit.js";
import PriceList from "./PriceList.js";
import PriceEdit from "./PriceEdit.js";
import ProjectEdit from "./ProjectEdit.js";
import ProjectList from "./ProjectList.js";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/activities' exact={true} component={ActivityList}/>
            <Route path='/activities/:id' component={ActivityEdit}/>
            <Route path='/companies' exact={true} component={CompanyList}/>
            <Route path='/companies/:id' component={CompanyEdit}/>
            <Route path='/units' exact={true} component={UnitList}/>
            <Route path='/units/:id' component={UnitEdit}/>
            <Route path='/currencies' exact={true} component={CurrencyList}/>
            <Route path='/currencies/:id' component={CurrencyEdit}/>
            <Route path='/customers' exact={true} component={CustomerList}/>
            <Route path='/customers/:id' component={CustomerEdit}/>
            <Route path='/invoices' exact={true} component={InvoiceList}/>
            <Route path='/invoices/:id' component={InvoiceEdit}/>
            <Route path='/prices' exact={true} component={PriceList}/>
            <Route path='/prices/:id' component={PriceEdit}/>
            <Route path='/projects' exact={true} component={ProjectList}/>
            <Route path='/projects/:id' component={ProjectEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;