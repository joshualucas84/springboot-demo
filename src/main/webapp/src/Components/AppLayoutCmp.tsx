import * as React from 'react';
import PropTypes from 'prop-types';

import * as mui from '@mui/material';
import * as muiIcons from '@mui/icons-material';

import FetcherForm from './FetcherForm';
import PrimeFinderAnimation from './PrimeFinderAnimation';

function ElevationScroll(props:any) {
  const { children, window } = props;

  const trigger = mui.useScrollTrigger({
    disableHysteresis: true,
    threshold: 0,
    target: window ? window() : undefined,
  });

  return React.cloneElement(children, {
    elevation: trigger ? 4 : 0,
  });
}

ElevationScroll.propTypes = {
  children: PropTypes.element.isRequired,

  window: PropTypes.func,
};

export default function AppLayoutCmp(props:any) {

    const [data, setData] =
        React.useState<
        {
            n: number,
            primes:number[],
            multiplesLists: number[][]
        }
        >(
            {
                n: 30,
                primes:[2,3,5,7,11,13,17,19,23,29],
                multiplesLists:[[2,4,6,8,10,12,14,16,18,20,22,24,26,28,30],[3,9,12,15,18,21,24,27,30],[],[5,25,30]]
            }
    );

    const callBackSetData = (d:
        {
            n: number,
            primes:number[],
            multiplesLists: number[][]
        }
        ) => {
            setData(d);
        }

    const [render, setRender] = React.useState(true);

    React.useEffect(() => {

        setRender(false);

        window.setTimeout(() => {
            setRender(true);
        },0);

    },[data]);

    return (
        <React.Fragment>
        <mui.CssBaseline />
        <ElevationScroll {...props}>
            <mui.AppBar
                style={{
                    background: 'linear-gradient(45deg, #000000 20%, #FFFFFF 120%)'
                }}
            >
            <mui.Toolbar>
                <mui.IconButton
                    color="inherit"
                    aria-label="Menu"
                    style={{
                        marginLeft: -10,
                        marginRight: 10,
                    }}
                >
                    <muiIcons.Calculate />
                </mui.IconButton>
                <mui.Typography variant="h6" component="div">
                    Hexagon find Prime Demo
                </mui.Typography>
            </mui.Toolbar>
            </mui.AppBar>
        </ElevationScroll>
        <mui.Toolbar />
        <mui.Container>
            <mui.Box sx={{ my: 2 }}>
                <mui.Grid container direction="column" spacing={2}>
                    <mui.Grid item >
                        <mui.Card>
                            <mui.CardContent>
                                <FetcherForm
                                    callBackSetData={
                                        callBackSetData
                                    }
                                />
                            </mui.CardContent>
                        </mui.Card>
                    </mui.Grid>
                    <mui.Grid item>
                        <mui.Card>
                            <mui.CardContent>
                                {
                                    render
                                    &&
                                    <PrimeFinderAnimation data={data} />
                                }
                            </mui.CardContent>
                        </mui.Card>
                    </mui.Grid>
                </mui.Grid>
            </mui.Box>
        </mui.Container>
        </React.Fragment>
    );
}